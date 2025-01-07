package org.msa.service.rental.adaptor.in.web;

import lombok.RequiredArgsConstructor;
import org.msa.service.rental.adaptor.in.web.dto.*;
import org.msa.service.rental.application.port.in.*;
import org.msa.service.rental.domain.RentalCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RentalController {

    private final RentItemService rentItemService;
    private final ReturnItemService returnItemService;
    private final CreateRentalCardService createRentalCardService;
    private final OverdueItemService overdueItemService;
    private final ClearOverdueItemService clearOverdueItemService;
    private final InquiryService inquiryService;

    @PostMapping("/rentalcard")
    public ResponseEntity<RentalCardOutputDto> createRentalCard(@RequestBody UserInputDto userInputDto) {
        RentalCardOutputDto rentalCard = createRentalCardService.createRentalCard(userInputDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalCard);
    }

    @GetMapping("/rentalcard/{userId}")
    public ResponseEntity<RentalCardOutputDto> getRentalCard(@PathVariable String userId) {
        Optional<RentalCardOutputDto> rentalCard = inquiryService.getRentalCard(UserInputDto.builder().userId(userId).build());
        return ResponseEntity.ok(rentalCard.get());
    }

    @GetMapping("/rentalcard/{userId}/rentbook")
    public ResponseEntity<List<RentItemOutputDto>> getAllRentItems(@PathVariable String userId) {
        Optional<List<RentItemOutputDto>> allRentItems = inquiryService.getAllRentItems(UserInputDto.builder().userId(userId).build());
        return ResponseEntity.ok(allRentItems.get());
    }

    @GetMapping("/rentalcard/{userId}/returnbook")
    public ResponseEntity<List<ReturnItemOutputDto>> getAllReturnItems(@PathVariable String userId) {
        Optional<List<ReturnItemOutputDto>> allReturnItems = inquiryService.getAllReturnItems(UserInputDto.builder().userId(userId).build());
        return ResponseEntity.ok(allReturnItems.get());
    }

    @PostMapping("/rentalcard/rent")
    public ResponseEntity<RentalCardOutputDto> rentItem(@RequestBody UserItemInputDto userItemInputDto) throws Exception {
        RentalCardOutputDto rentalCard = rentItemService.rentItem(userItemInputDto);
        return ResponseEntity.ok(rentalCard);
    }

    @PostMapping("/rentalcard/return")
    public ResponseEntity<RentalCardOutputDto> returnItem(@RequestBody UserItemInputDto userItemInputDto) throws Exception {
        RentalCardOutputDto rentalCard = returnItemService.returnItem(userItemInputDto);
        return ResponseEntity.ok(rentalCard);
    }

    @PostMapping("/rentalcard/overdue")
    public ResponseEntity<RentalCardOutputDto> overdueItem(@RequestBody UserItemInputDto userItemInputDto) {
        RentalCardOutputDto rentalCardOutputDto = overdueItemService.overDueItem(userItemInputDto);
        return ResponseEntity.ok(rentalCardOutputDto);
    }

    @PostMapping("/rentalcard/clearoverdue")
    public ResponseEntity<RentalResultOutputDto> clearOverdueItem(@RequestBody ClearOverdueInfoDto clearOverdueInfoDto) throws Exception {
        RentalResultOutputDto rentalResultOutputDto = clearOverdueItemService.clearOverdueItem(clearOverdueInfoDto);
        return ResponseEntity.ok(rentalResultOutputDto);
    }
}

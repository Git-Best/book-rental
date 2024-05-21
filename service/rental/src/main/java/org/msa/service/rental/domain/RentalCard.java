package org.msa.service.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalCard {
    private RentalCardNo rentalCardNo;
    private IdName member;
    private RentStatus rentStatus;
    private LateFee lateFee;
    private List<RentalItem> rentalItemList = new ArrayList<>();
    private List<ReturnItem> returnItemList = new ArrayList<>();

    private void addRentalItem(RentalItem rentalItem) {
        this.rentalItemList.add(rentalItem);
    }

    private void removeRentalItem(RentalItem rentalItem) {
        this.rentalItemList.remove(rentalItem);
    }

    private void addReturnItem(ReturnItem returnItem) {
        this.returnItemList.add(returnItem);
    }

    public static RentalCard createRentalCard(IdName creator) {
        RentalCard rentalCard = new RentalCard();
        rentalCard.setRentalCardNo(RentalCardNo.createRentalCardNo());
        rentalCard.setMember(creator);
        rentalCard.setRentStatus(RentStatus.RENT_AVAILABLE);
        rentalCard.setLateFee(LateFee.createLateFee());
        return rentalCard;
    }

    public RentalCard rentItem(Item item) {
        checkRentalAvailable();
        this.addRentalItem(RentalItem.createRentalItem(item));
        return this;
    }

    private void checkRentalAvailable() {
        if (this.rentStatus == RentStatus.RENT_UNAVAILABLE) {
            throw new RuntimeException("대여 불가능한 상태입니다.");
        }

        if(this.rentalItemList.size() > 5) {
            throw new RuntimeException("대여 가능한 수량을 초과하였습니다.");
        }
    }

    public RentalCard returnItem(Item item, LocalDate returnDate) {
        RentalItem rentalItem = this.rentalItemList.stream()
                .filter(rent -> rent.getItem().equals(item))
                .findFirst().get();
        calculateLateFee(rentalItem, returnDate);
        this.addReturnItem(ReturnItem.createReturnItem(rentalItem));
        this.removeRentalItem(rentalItem);
        return this;
    }

    private void calculateLateFee(RentalItem rentalItem, LocalDate returnDate) {
        if(returnDate.isBefore(rentalItem.getOverdueDate())) return;

        long days = returnDate.toEpochDay() - rentalItem.getOverdueDate().toEpochDay();
        long point = days * 10;
        this.lateFee.addPoint(point);
    }

    public RentalCard overdueItem(Item item) {
        RentalItem rentalItem = this.rentalItemList.stream().filter(x -> x.getItem().equals(item)).findFirst().get();
        rentalItem.setOverdued(true);
        this.rentStatus = RentStatus.RENT_UNAVAILABLE;
        rentalItem.setOverdueDate(LocalDate.now().minusDays(1));
        return this;
    }

    public long makeAvailableRental(long point) {
        if(this.rentalItemList.isEmpty()) throw new RuntimeException("모든 도서가 반납되어야 정지를 해제할 수 있습니다.");
        if(this.getLateFee().getPoint() != point) throw new RuntimeException("해당 포인트로연체를 해제할 수 없습니다.");

        this.setLateFee(lateFee.removePoint(point));
        if(this.getLateFee().getPoint() == 0) this.rentStatus = RentStatus.RENT_AVAILABLE;
        return this.getLateFee().getPoint();
    }
}

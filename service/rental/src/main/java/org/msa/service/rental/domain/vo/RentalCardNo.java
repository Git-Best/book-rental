package org.msa.service.rental.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalCardNo {
    private String no;

    public static RentalCardNo createRentalCardNo() {
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + "-" + uuid;
        RentalCardNo rentalCardNo = new RentalCardNo();
        rentalCardNo.setNo(str);

        return rentalCardNo;
    }
}

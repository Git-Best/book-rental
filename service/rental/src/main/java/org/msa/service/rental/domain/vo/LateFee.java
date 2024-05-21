package org.msa.service.rental.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LateFee {
    private long point;

    public static LateFee createLateFee() {
        return new LateFee(0);
    }

    public LateFee addPoint(long point) {
        return new LateFee(this.point + point);
    }

    public LateFee removePoint(long point) {
        if(point > this.point) {
            throw new IllegalArgumentException("point is not enough");
        }

        return new LateFee(this.point - point);
    }
}

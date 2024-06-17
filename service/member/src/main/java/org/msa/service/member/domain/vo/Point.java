package org.msa.service.member.domain.vo;

public class Point {
    private long pointValue;

    public long addPoint(long point) {
        this.pointValue += point;
        return this.pointValue;
    }

    public long removePoint(long point) {
        if(point > this.pointValue) {
            throw new IllegalArgumentException("포인트가 부족합니다.");
        }

        this.pointValue -= point;
        return this.pointValue;
    }

    public static Point createPoint() {
        return new Point();
    }
}

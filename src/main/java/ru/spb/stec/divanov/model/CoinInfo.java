package ru.spb.stec.divanov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoinInfo {

    private int id;
    private String name;
    private String fullName;
    private String internal;
    private String imageURL;
    private String url;
    private String algorithm;
    private String proofType;
    private Rating rating;
    private long netHashesPerSecond;
    private long blockNumber;
    private long blockTime;
    private double blockReward;
    private String assertDate;
    private long maxSupply;
    private String type;
    private String docType;

     public static class Rating {
        private Weiss weiss;

        public static class Weiss {
            private String rating;
            private String technologyAdoptionRating;
            private String marketPerformanceRating;
        }
    }

    @Override
    public String toString() {
        return "CoinInfo{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}

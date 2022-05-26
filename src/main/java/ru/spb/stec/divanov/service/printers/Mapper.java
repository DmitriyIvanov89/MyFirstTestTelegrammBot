package ru.spb.stec.divanov.service.printers;

import ru.spb.stec.divanov.model.BaseRate;

public class Mapper {

    public String mapping(BaseRate baseRate) {
        return baseRate.toString();
    }
}

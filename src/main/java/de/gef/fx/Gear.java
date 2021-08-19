package de.gef.fx;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import javafx.util.converter.BigDecimalStringConverter;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Gear {
    private int id;
    private String description;
    private ZonedDateTime date;
    private BigDecimal acquisitionCost;
    private BigDecimal currentValue;
}

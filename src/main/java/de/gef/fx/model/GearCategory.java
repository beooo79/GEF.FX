package de.gef.fx.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GearCategory {
    private List<Gear> gear;
    private String name;    
}

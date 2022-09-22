package com.kenzie.app;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CluesDTOList {
    @JsonProperty("clues")
    private List<CluesDTO> clues;

    public List<CluesDTO> getClues() {
        return this.clues;
    }

    public void setClues(List<CluesDTO> clues) {
        this.clues = clues;
    }

}

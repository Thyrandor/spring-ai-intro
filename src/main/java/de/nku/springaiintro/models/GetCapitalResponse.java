package de.nku.springaiintro.models;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

public record GetCapitalResponse(@JsonPropertyDescription("Der Name der Hauptstadt") String answer) {
}

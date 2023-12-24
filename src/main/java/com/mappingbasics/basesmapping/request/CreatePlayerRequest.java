package com.mappingbasics.basesmapping.request;

import com.mappingbasics.basesmapping.helpers.PlayerValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor @AllArgsConstructor
public class CreatePlayerRequest {
    @NotNull(message = PlayerValidation.NAME_REGEX_MESSAGE)
    @NotEmpty(message = PlayerValidation.NAME_REGEX_MESSAGE)
    @Pattern(regexp=PlayerValidation.NAME_REGEX)
    private String playerName;

    @NotEmpty(message = PlayerValidation.NAME_REGEX_MESSAGE)
    private  int vie;
}

package com.banks.lostunes.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by banks on 002 Aug 02 2017 7:38 AM.
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
public class TokenPojo {
    @JsonProperty("id_token")
    private String idToken;
}

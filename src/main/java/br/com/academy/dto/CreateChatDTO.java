/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ozzy
 */
@Getter
@Setter
public class CreateChatDTO {
    private List<String> users;

    public CreateChatDTO(List<String> users) {
        this.users = users;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ozzy
 */
@Getter
@Setter
public class User extends ModelBase {

    private String username;
    private String department;

    @Override
    public String toString() {
        return this.username;
    }

}

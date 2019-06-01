/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ozzy
 */
@Getter
@Setter
public class Department extends ModelBase {

    private String name;
    private List<User> users;

    @Override
    public String toString() {
        return this.name;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academy.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ozzy
 */
@Getter
@Setter
public class ModelBase implements Serializable {

    private Integer id;
    @SerializedName("created_at")
    private Date createdAt;
    @SerializedName("modified_at")
    private Date modifiedAt;
    private boolean active;
}

package com.sportswork.sportswork.core.baseEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author dengwei
 * @date 2020/1/9 13:38
 * @description
 */
@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseEntity implements Serializable {
    /**
     * 全局唯一Id
     */

    protected String id;
}

package com.stadion.api.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class SqlVO implements Serializable {

   private static final long serialVersionUID = 4008156682073033724L;

   @ApiModelProperty(value = "쿼리", example = "query")
   Object query;

   @Override
	public String toString() {
		return "SqlVO [obj=" + query + "]";
	}
	
	public Object getquery() {
      return query;
   }

   public void setquery(Object obj) {
      this.query = obj;
   }
} 
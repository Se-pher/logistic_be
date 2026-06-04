package com.example.auth.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*d

@Since 5/25/2026
@Author qle20

*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;

    public ApiResponse(T data){
        this.code = 200;
        this.message = "Success";
        this.data = data;
    }

}

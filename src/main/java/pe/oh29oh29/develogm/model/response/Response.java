package pe.oh29oh29.develogm.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Response {

    @NonNull
    private int code;

    private Object data;

}

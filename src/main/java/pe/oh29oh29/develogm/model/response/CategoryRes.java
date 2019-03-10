package pe.oh29oh29.develogm.model.response;

import lombok.Data;

@Data
public class CategoryRes {

    private String id;

    private String name;

    private int depth;

    private int ordering;

    private boolean isVisible;
}

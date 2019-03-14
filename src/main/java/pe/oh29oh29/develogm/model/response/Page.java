package pe.oh29oh29.develogm.model.response;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Page {

    public Page(int target, int total) {

        int countPerBlock = 5;

        this.target = target;
        this.total = total;

        this.start = target - ((target % countPerBlock == 0) ? countPerBlock : target % countPerBlock) + 1;
        this.end = this.start + countPerBlock;

        if (this.end > this.total) {
            this.end = this.total;
        }
    }

    @NonNull
    private int target;
    @NonNull
    private int total;
    private int start;
    private int end;

}

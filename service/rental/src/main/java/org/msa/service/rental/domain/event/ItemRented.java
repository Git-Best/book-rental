package org.msa.service.rental.domain.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.msa.service.rental.domain.vo.IdName;
import org.msa.service.rental.domain.vo.Item;

@AllArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IdName idName;
    private Item item;
    private long point;
}

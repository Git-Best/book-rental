package org.msa.service.rental.domain.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.IdName;
import org.msa.service.rental.domain.vo.Item;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IdName idName;
    private Item item;
    private long point;
}

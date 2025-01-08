package org.msa.service.book.domain.event;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemReturned extends ItemRented {

    public ItemReturned(IdName idName, Item item, long point) {
        super(idName, item, point);
    }
}

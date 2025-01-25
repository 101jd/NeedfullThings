package org.diplom.NeedfullThings.repository.listrepos;

import org.springframework.stereotype.Repository;

@Repository
public class WishListRepo extends ListRepo {
    public WishListRepo() {
        super("wishlist");
    }
}

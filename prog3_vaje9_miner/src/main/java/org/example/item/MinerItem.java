package org.example.item;

import org.example.Block;

public class MinerItem implements Item{
    public Block block;

    public MinerItem(Block block) {
        this.block = block;
    }
}

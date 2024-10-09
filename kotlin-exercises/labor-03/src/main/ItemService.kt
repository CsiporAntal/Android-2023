package main

import ItemRepository

class ItemService(private val itemRepository: ItemRepository) {
    fun selectRandomItems(count: Int): List<Item> {
        return itemRepository.selectRandomItems(count)
    }
}

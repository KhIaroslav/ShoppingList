package com.khiaroslav.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItemUseCase(shopItemId: Int): ShopItem {
       return shopListRepository.getShopItemUseCase(shopItemId)
    }
}
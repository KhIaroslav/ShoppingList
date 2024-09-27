package com.khiaroslav.shoppinglist.presentation

import androidx.lifecycle.ViewModel

import com.khiaroslav.shoppinglist.data.ShopListRepositoryImpl //??????

import com.khiaroslav.shoppinglist.domain.DeleteShopItemUseCase
import com.khiaroslav.shoppinglist.domain.EditShopItemUseCase
import com.khiaroslav.shoppinglist.domain.GetShopListUseCase
import com.khiaroslav.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl ///???????

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}
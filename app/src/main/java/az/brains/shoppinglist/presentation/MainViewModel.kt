package az.brains.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import az.brains.shoppinglist.data.ShopListRepositoryImpl
import az.brains.shoppinglist.domain.DeleteShopItemUseCase
import az.brains.shoppinglist.domain.EditShopItemUseCase
import az.brains.shoppinglist.domain.GetShopListUseCase
import az.brains.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

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
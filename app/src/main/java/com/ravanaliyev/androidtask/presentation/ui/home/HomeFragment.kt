package com.ravanaliyev.androidtask.presentation.ui.home

import com.ravanaliyev.androidtask.R
import com.ravanaliyev.androidtask.common.BaseFragment
import com.ravanaliyev.androidtask.data.model.ProductModel
import com.ravanaliyev.androidtask.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val adapter by lazy { ProductAdapter() }

    val products = listOf(
        ProductModel(
            id = 1,
            image = R.drawable.img_1,
            title = "Spicy Salmon Bento",
            description = "A delightful combination of salmon and spicy sauce."
        ),
        ProductModel(
            id = 2,
            image = R.drawable.img_2,
            title = "Classic Karaage Plate",
            description = "Japanese fried chicken served with rice and miso soup."
        ),
        ProductModel(
            id = 3,
            image = R.drawable.img_3,
            title = "Vegetarian Sushi Box",
            description = "An assortment of fresh vegetarian sushi rolls."
        ),
        ProductModel(
            id = 4,
            image = R.drawable.img_4,
            title = "Teriyaki Chicken Bento",
            description = "Grilled chicken glazed with teriyaki sauce."
        ),
        ProductModel(
            id = 5,
            image = R.drawable.img_5,
            title = "Tempura Delight",
            description = "Crispy tempura shrimp and vegetables with dipping sauce."
        ),
        ProductModel(
            id = 6,
            image = R.drawable.img_1,
            title = "Black Pepper Beef Bowl",
            description = "Tender beef stir-fried with black pepper sauce."
        ),
        ProductModel(
            id = 7,
            image = R.drawable.img_2,
            title = "Salmon Sashimi Set",
            description = "Freshly sliced salmon served with soy sauce and wasabi."
        ),
        ProductModel(
            id = 8,
            image = R.drawable.img_3,
            title = "Unagi Don",
            description = "Grilled eel served over steamed rice with eel sauce."
        ),
        ProductModel(
            id = 9,
            image = R.drawable.img_4,
            title = "Matcha Dessert Box",
            description = "Assorted matcha-flavored sweets and treats."
        ),
        ProductModel(
            id = 10,
            image = R.drawable.img_5,
            title = "Chicken Katsu Bento",
            description = "Crispy breaded chicken served with rice and curry."
        ),
        ProductModel(
            id = 11,
            image = R.drawable.img_1,
            title = "Pork Tonkatsu Bowl",
            description = "Deep-fried breaded pork cutlet over rice."
        ),
        ProductModel(
            id = 12,
            image = R.drawable.img_2,
            title = "Shrimp Udon Soup",
            description = "Thick udon noodles in broth with shrimp tempura."
        ),
        ProductModel(
            id = 13,
            image = R.drawable.img_3,
            title = "Vegetable Gyoza Platter",
            description = "Pan-fried vegetable dumplings with dipping sauce."
        ),
        ProductModel(
            id = 14,
            image = R.drawable.img_4,
            title = "Curry Ramen Bowl",
            description = "Rich curry-flavored ramen with tender chicken."
        ),
        ProductModel(
            id = 15,
            image = R.drawable.img_5,
            title = "Miso Soup Combo",
            description = "Classic miso soup served with rice and side dishes."
        )
    )


    override fun onViewCreateFinish() {
        setup()
    }

    private fun setup() {
        with(binding) {
            rvProducts.adapter = adapter

            adapter.onClickShare = {
                showToast("Share")
            }
            adapter.onClickLike = {
                showToast("Like")
            }
            adapter.onClickItem = {
                showToast("item : ${it.id} name : ${it.title}")
            }

            adapter.submitData(products)

        }
    }

}
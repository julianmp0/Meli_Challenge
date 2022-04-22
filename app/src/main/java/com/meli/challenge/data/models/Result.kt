package com.meli.challenge.data.models


import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class Result(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    @SerializedName("address")
    val address: Address,
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("buying_mode")
    val buyingMode: String,
    @SerializedName("catalog_listing")
    val catalogListing: Boolean,
    @SerializedName("catalog_product_id")
    val catalogProductId: String,
    @SerializedName("category_id")
    val categoryId: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("differential_pricing")
    val differentialPricing: DifferentialPricing,
    @SerializedName("discounts")
    val discounts: Any,
    @SerializedName("domain_id")
    val domainId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("installments")
    val installments: Installments,
    @SerializedName("listing_type_id")
    val listingTypeId: String,
    @SerializedName("match_score")
    val matchScore: Any,
    @SerializedName("melicoin")
    val melicoin: Any,
    @SerializedName("offer_score")
    val offerScore: Any,
    @SerializedName("offer_share")
    val offerShare: Any,
    @SerializedName("official_store_id")
    val officialStoreId: Any,
    @SerializedName("order_backend")
    val orderBackend: Int,
    @SerializedName("original_price")
    val originalPrice: Any,
    @SerializedName("permalink")
    val permalink: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("prices")
    val prices: Prices,
    @SerializedName("sale_price")
    val salePrice: Any,
    @SerializedName("seller")
    val seller: Seller,
    @SerializedName("seller_address")
    val sellerAddress: SellerAddress,
    @SerializedName("shipping")
    val shipping: Shipping,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("sold_quantity")
    val soldQuantity: Int,
    @SerializedName("stop_time")
    val stopTime: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("thumbnail_id")
    val thumbnailId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean,
    @SerializedName("winner_item_id")
    val winnerItemId: Any
) {
    fun buildSellerAdress(): String? {
        val result = StringBuilder()

        sellerAddress.let {
            if (it.state.name.isNullOrEmpty().not()){
                result.append(it.state.name)
            }
            if (it.city.name.isNullOrEmpty().not()){
                if (result.isNotEmpty()){
                    result.append(", ")
                }
                result.append(it.city.name)
            }
        }

        return if (result.isNotEmpty()) result.toString() else null
    }
}
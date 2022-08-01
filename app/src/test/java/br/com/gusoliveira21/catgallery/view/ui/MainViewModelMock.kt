package br.com.gusoliveira21.catgallery.view.ui

import br.com.data.modelResultRetrofit.AdConfig
import br.com.data.modelResultRetrofit.CatDataClass
import br.com.data.modelResultRetrofit.Data
import br.com.data.modelResultRetrofit.DescriptionAnnotations
import br.com.data.modelResultRetrofit.Image
import br.com.data.modelResultRetrofit.Tag

val catDataMocked = br.com.data.modelResultRetrofit.CatDataClass(
    data = listOf(
        br.com.data.modelResultRetrofit.Data(
            account_id = 12309091,
            account_url = null,
            ad_config =
            br.com.data.modelResultRetrofit.AdConfig(
                highRiskFlags = listOf(""),
                safeFlags = listOf(""),
                showsAds = true,
                unsafeFlags = listOf(""),
                wallUnsafeFlags = listOf("")
            ),
            ad_type = null,
            ad_url = null,
            comment_count = null,
            cover = null,
            cover_height = null,
            cover_width = null,
            datetime = null,
            description = null,

            downs = 0,
            favorite = false,
            favorite_count = null,
            id = null,
            images_count = 1,
            in_gallery = true,
            in_most_viral = false,
            include_album_ads = false,
            is_ad = false,
            is_album = true,
            layout = "blog",
            link = "https://imgur.com/a/28BrkMP",
            nsfw = null,
            points = 5,
            privacy = "hidden",
            score = 5,
            section = "",
            tags = listOf(
                br.com.data.modelResultRetrofit.Tag(
                    accent = "B85E44",
                    background_hash = "5uFU9FR",
                    background_is_animated = false,
                    description = "",
                    description_annotations = br.com.data.modelResultRetrofit.DescriptionAnnotations(),
                    display_name = "fundraising",
                    followers = 35,
                    following = false,
                    is_promoted = false,
                    is_whitelisted = false,
                    logo_destination_url = "null",
                    logo_hash = "null",
                    name = "fundraising",
                    thumbnail_hash = "null",
                    thumbnail_is_animated = false,
                    total_items = 354
                )
            ),
            title = "getting hot out there..",
            topic = null,
            topic_id = null,
            ups = null,
            views = 11,
            vote = null,
            images = listOf(
                br.com.data.modelResultRetrofit.Image(
                    account_id = null,
                    account_url = null,
                    ad_type = 1,
                    ad_url = "String",
                    animated = false,
                    bandwidth = null,
                    comment_count = 0,
                    datetime = 0,
                    description = null,
                    downs = 0,
                    edited = "String",
                    favorite = null,
                    favorite_count = null,
                    has_sound = false,
                    height = 960,
                    id = "8GkvlbT",
                    in_gallery = false,
                    in_most_viral = false,
                    is_ad = false,
                    link = "//i.imgur.com/8GkvlbT.jpg",
                    nsfw = null,
                    points = null,
                    score = null,
                    section = null,
                    size = 67833,
                    title = "null",
                    type = "image/jpeg",
                    ups = null,
                    views = 11,
                    vote = null,
                    width = 720,
                    tags = listOf(
                        br.com.data.modelResultRetrofit.Tag(
                            accent = "B85E44",
                            background_hash = "5uFU9FR",
                            background_is_animated = false,
                            description = "description_annotations=br.com.data.DescriptionAnnotations@204460b",
                            display_name = "fundraising",
                            followers = 35,
                            following = false,
                            is_promoted = false,
                            is_whitelisted = false,
                            logo_destination_url = false,
                            logo_hash = false,
                            name = "fundraising",
                            thumbnail_hash = false,
                            thumbnail_is_animated = false,
                            total_items = 354,
                            description_annotations = br.com.data.modelResultRetrofit.DescriptionAnnotations()
                        )
                    )
                )
            )
        )
    )
)

val catDataExpected = listOf(
    "//i.imgur.com/8GkvlbT.jpg"
)
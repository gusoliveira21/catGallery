package br.com.data.modelResultRetrofit

data class AdConfig(
    val highRiskFlags: List<Any>,
    val safeFlags: List<String>,
    val showsAds: Boolean,
    val unsafeFlags: List<Any>,
    val wallUnsafeFlags: List<Any>
)
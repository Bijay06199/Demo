package com.example.gyankunj.data.repositories

import com.example.gyankunj.data.api.gyankunjApiService
import com.example.gyankunj.ui.home.api.BannerResponse
import retrofit2.Response

class GetBannerRepository(var apiService: gyankunjApiService) {
suspend fun getBanner(): Response<BannerResponse> {

    return apiService.getBanner(1,10)

}
}
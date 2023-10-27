package com.example.storebanhang.Retrofit;

import com.example.storebanhang.model.DonHangModel;
import com.example.storebanhang.model.LoaiSpModel;
import com.example.storebanhang.model.SanPhamMoiModel;
import com.example.storebanhang.model.UserModel;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiBanHang
{
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();
    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();
    @POST("chitiet.php")
    @FormUrlEncoded
    Observable<SanPhamMoiModel>getSanPham(
         @Field("page") int page,
         @Field("loai") int loai
    );
    @POST("dangky.php")
    @FormUrlEncoded
    Observable<UserModel>dangKi(
            @Field("email") String email,
            @Field("pass") String pass,
            @Field("username") String username,
            @Field("mobile") String mobile
    );
    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable<UserModel>dangNhap(
            @Field("email") String email,
            @Field("pass") String pass
    );
    @POST("donhang.php")
    @FormUrlEncoded
    Observable<UserModel> createOder(
            @Field("email") String email,
            @Field("sdt") String sdt,
            @Field("tongtien") String tongtien,
            @Field("iduser") int id,
            @Field("diachi") String diachi,
            @Field("soluong") int soluong,
            @Field("chitiet") String chitiet
    );
    @POST("xemdonhang.php")
    @FormUrlEncoded
    Observable<DonHangModel>xemDonHang(
            @Field("iduser") int id
    );
}

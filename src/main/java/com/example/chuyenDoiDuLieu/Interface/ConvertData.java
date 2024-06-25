package com.example.chuyenDoiDuLieu.Interface;

public interface ConvertData<T> {
    byte[] Encode(T duLieu);
    T Decode(byte[] duLieuByte);
}

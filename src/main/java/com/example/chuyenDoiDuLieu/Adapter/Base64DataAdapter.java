package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ConvertData;

import java.util.Base64;

public class Base64DataAdapter implements ConvertData<String> {
    private static Base64DataAdapter base64DataAdapter;

    public static Base64DataAdapter getInstance(){
        if(base64DataAdapter != null)
            return base64DataAdapter;
        base64DataAdapter = new Base64DataAdapter();
        return base64DataAdapter;
    }
    @Override
    public byte[] Encode(String duLieu) {
        return Base64.getDecoder().decode(duLieu);
    }

    @Override
    public String Decode(byte[] duLieuByte) {
        return Base64.getEncoder().encodeToString(duLieuByte);
    }
}

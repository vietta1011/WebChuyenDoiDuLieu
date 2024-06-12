package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64DataAdapter implements ChuyenDoiDuLieu {
    @Override
    public byte[] Encode(Object duLieu) {
        String base64String = duLieu.toString();
        return Base64.getDecoder().decode(base64String);
    }

    @Override
    public Object Decode(byte[] duLieuByte) {
        return Base64.getEncoder().encodeToString(duLieuByte);
    }
}

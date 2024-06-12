package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class StringDataAdapter implements ChuyenDoiDuLieu {
    @Override
    public byte[] Encode(Object duLieu) {
        return duLieu.toString().getBytes();
    }

    @Override
    public Object Decode(byte[] duLieuByte) {
        return new String((byte[]) duLieuByte, StandardCharsets.UTF_8);
    }
}

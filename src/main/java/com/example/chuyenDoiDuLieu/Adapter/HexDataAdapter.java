package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.stereotype.Component;

import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;

@Component
public class HexDataAdapter implements ChuyenDoiDuLieu {
    @Override
    public byte[] Encode(Object duLieu) {
        if(duLieu.toString().length() % 2 != 0){
            throw new IllegalArgumentException("Độ dài của chuỗi hex phải là số chẵn");
        }
        String hexString = duLieu.toString();
        return hexStringToByteArray(hexString);
    }

    @Override
    public Object Decode(byte[] duLieuByte) {
        StringBuilder hex = new StringBuilder();
        for (byte b : duLieuByte) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }
}

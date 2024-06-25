package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ConvertData;
import static ch.qos.logback.core.encoder.ByteArrayUtil.hexStringToByteArray;

public class HexDataAdapter implements ConvertData<String> {
    private static HexDataAdapter hexDataAdapter;

    public static HexDataAdapter getInstance() {
        if (hexDataAdapter != null)
            return hexDataAdapter;
        hexDataAdapter = new HexDataAdapter();
        return hexDataAdapter;
    }

    @Override
    public byte[] Encode(String duLieu) {
        if(duLieu.length() % 2 != 0){
            throw new IllegalArgumentException("Độ dài của chuỗi hex phải là số chẵn");
        }
        return hexStringToByteArray(duLieu);
    }

    @Override
    public String Decode(byte[] duLieuByte) {
        StringBuilder hex = new StringBuilder();
        for (byte b : duLieuByte) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }
}

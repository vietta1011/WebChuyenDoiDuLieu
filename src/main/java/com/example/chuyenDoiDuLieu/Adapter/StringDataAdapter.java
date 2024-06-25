package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ConvertData;

import java.nio.charset.StandardCharsets;

public class StringDataAdapter implements ConvertData<String> {
    private static StringDataAdapter stringDataAdapter;

    public static StringDataAdapter getInstance() {
        if (stringDataAdapter != null)
            return stringDataAdapter;
        stringDataAdapter = new StringDataAdapter();
        return stringDataAdapter;
    }

    @Override
    public byte[] Encode(String duLieu) {
        return duLieu.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String Decode(byte[] duLieuByte) {
        return new String(duLieuByte, StandardCharsets.UTF_8);
    }
}

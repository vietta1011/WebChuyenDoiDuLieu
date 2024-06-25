package com.example.chuyenDoiDuLieu.Adapter;

import com.example.chuyenDoiDuLieu.Interface.ConvertData;

public class ByteDataAdapter implements ConvertData<String> {
    private static ByteDataAdapter byteDataAdapter;

    public static ByteDataAdapter getInstance() {
        if (byteDataAdapter != null)
            return byteDataAdapter;
        byteDataAdapter = new ByteDataAdapter();
        return byteDataAdapter;
    }

    @Override
    public byte[] Encode(String duLieu) {
        if (duLieu.startsWith("[") && duLieu.endsWith("]")) {
            duLieu = duLieu.substring(1, duLieu.length() - 1);
        }
        String[] byteValues = duLieu.split(",");
        byte[] byteArray = new byte[byteValues.length];
        for (int i = 0; i < byteValues.length; i++) {
            byteArray[i] = (byte) Integer.parseInt(byteValues[i].trim());
        }
        return byteArray;
    }

    @Override
    public String Decode(byte[] duLieuByte) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < duLieuByte.length; i++) {
            sb.append(duLieuByte[i]);
            if (i < duLieuByte.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

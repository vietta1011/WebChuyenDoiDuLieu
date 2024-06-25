package com.example.chuyenDoiDuLieu;

import com.example.chuyenDoiDuLieu.Adapter.Base64DataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.ByteDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.HexDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.StringDataAdapter;
import com.example.chuyenDoiDuLieu.Interface.ConvertData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ChuyenDoiDuLieuApplication {

    public static void main(String[] args) {
        String string = "Viet1011.";
        String hex = "56696574313031312E";
        byte[] byteArray = {86, 105, 101, 116, 49, 48, 49, 49, 46};
        String base64 = "VmlldDEwMTEu";

        // Encode từ Base64 về mảng Byte và từ mảng Byte sang Base64
        ConvertData<String> baseAdapter = Base64DataAdapter.getInstance();
        byte[] byteDataFromBase64 = baseAdapter.Encode(base64);
        String base64DataFromByte = baseAdapter.Decode(byteDataFromBase64);
        System.out.println("Byte array after Base64 encode: " + Arrays.toString(byteDataFromBase64));
        System.out.println("Base64 after decode: " + base64DataFromByte);

        // Encode từ String về mảng Byte và từ mảng Byte sang String
        ConvertData<String> stringAdapter = StringDataAdapter.getInstance();
        byte[] byteDataFromString = stringAdapter.Encode(string);
        String stringDataFromByte = stringAdapter.Decode(byteDataFromString);
        System.out.println("Byte array after String encode: " + Arrays.toString(byteDataFromString));
        System.out.println("String after decode: " + stringDataFromByte);

        // Encode từ Hex về mảng Byte và từ mảng Byte sang Hex
        ConvertData<String> hexAdapter = HexDataAdapter.getInstance();
        byte[] byteDataFromHex = hexAdapter.Encode(hex);
        String hexDataFromByte = hexAdapter.Decode(byteDataFromHex);
        System.out.println("Byte array after Hex encode: " + Arrays.toString(byteDataFromHex));
        System.out.println("Hex after decode: " + hexDataFromByte);

        // Encode từ ByteArray về mảng Byte và từ mảng Byte sang ByteArray
        ConvertData<String> byteAdapter = ByteDataAdapter.getInstance();
        byte[] byteDataFromByteArray = byteAdapter.Encode(Arrays.toString(byteArray));
        String byteArrayFromByteData = byteAdapter.Decode(byteDataFromByteArray);
        System.out.println("Byte array after encode: " + Arrays.toString(byteDataFromByteArray));
        System.out.println("Byte array after decode: " + byteArrayFromByteData);

        SpringApplication.run(ChuyenDoiDuLieuApplication.class, args);
    }

}

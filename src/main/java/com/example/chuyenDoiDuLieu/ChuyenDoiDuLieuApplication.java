package com.example.chuyenDoiDuLieu;

import com.example.chuyenDoiDuLieu.Adapter.Base64DataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.ByteDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.HexDataAdapter;
import com.example.chuyenDoiDuLieu.Adapter.StringDataAdapter;
import com.example.chuyenDoiDuLieu.Interface.ChuyenDoiDuLieu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@SpringBootApplication
public class ChuyenDoiDuLieuApplication {

	public static void main(String[] args) {
		String string = "Viet1011.";
		String hex = "56696574313031312E";
		byte[] byteArray = {86, 105, 101, 116, 49, 48, 49, 49, 46};
		String base64 = "VmlldDEwMTEu";

		// Encode từ Base về mảng Byte và từ mảng Byte sang Base
		ChuyenDoiDuLieu baseAdapter = new Base64DataAdapter();
		byte[] byteDataFromBase = baseAdapter.Encode(base64);
		String baseDataFromByte = (String) baseAdapter.Decode(byteDataFromBase);
		System.out.println("Byte array after encode: " + Arrays.toString(byteDataFromBase));
		System.out.println("Base after decode: " + baseDataFromByte);

		// Encode từ String về mảng Byte và từ mảng Byte sang String
		ChuyenDoiDuLieu stringAdapter = new StringDataAdapter();
		byte[] byteDataFromString = stringAdapter.Encode(string);
		String stringDataFromByte = (String) stringAdapter.Decode(byteDataFromString);
		System.out.println("Byte array after encode: " + Arrays.toString(byteDataFromString));
		System.out.println("String after decode: " + stringDataFromByte);

		// Encode từ Hex về mảng Byte và từ mảng Byte sang Hex
		ChuyenDoiDuLieu hexAdapter = new HexDataAdapter();
		byte[] byteDataFromHex = hexAdapter.Encode(hex);
		String hexDataFromByte = (String) hexAdapter.Decode(byteDataFromHex);
		System.out.println("Byte array after encode: " + Arrays.toString(byteDataFromHex));
		System.out.println("Hex after decode: " + hexDataFromByte);

		// Encode từ Byte về mảng Byte và từ mảng Byte sang Byte
		ChuyenDoiDuLieu byteAdapter = new ByteDataAdapter();
		byte[] byteDataFromByte = byteAdapter.Encode(byteArray);
		String byteDataFromByteArray = (String) byteAdapter.Decode(byteDataFromByte);
		System.out.println("Byte array after encode: " + Arrays.toString(byteDataFromByte));
		System.out.println("Byte after decode: " + byteDataFromByteArray);

		SpringApplication.run(ChuyenDoiDuLieuApplication.class, args);
	}

}

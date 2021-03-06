package com.polidea.flutter_ble_lib.converter;

import android.support.annotation.Nullable;

import com.polidea.flutter_ble_lib.SingleCharacteristicResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class SingleCharacteristicResponseJsonConverter implements JsonConverter<SingleCharacteristicResponse> {

    private interface Metadata {
        String UUID = "serviceUuid";
        String ID = "serviceId";
        String CHARACTERISTIC = "characteristic";
        String TRANSACTION_ID = "transactionId";
    }

    private CharacteristicJsonConverter characteristicJsonConverter = new CharacteristicJsonConverter();

    @Nullable
    @Override
    public String toJson(SingleCharacteristicResponse value) throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(Metadata.UUID, value.getServiceUuid());
        jsonObject.put(Metadata.ID, value.getServiceId());
        jsonObject.put(Metadata.TRANSACTION_ID, value.getTransactionId());

        jsonObject.put(Metadata.CHARACTERISTIC, characteristicJsonConverter.toJsonObject(value.getCharacteristic()));
        return jsonObject.toString();
    }
}

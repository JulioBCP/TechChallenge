package com.fiap.techchallenge.carrental;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarRentalApplicationTests {

	@Test
	void contextLoads() {

		try {
			String url = "localhost:8080/Usuarios";
			URL obj = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) obj.openConnection();

			// Configurar a requisição para método POST
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Content-Type", "application/json");

			// Enviar os dados JSON
			String jsonInputString = "../payloadsJson/aluguel0/Usuario0.json"; // Substitua pelo seu JSON
			urlConnection.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream())) {
				wr.writeBytes(jsonInputString);
				wr.flush();
			}

			// Obter a resposta
			int responseCode = urlConnection.getResponseCode();
			System.out.println("Código de resposta: " + responseCode);

			try (BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				System.out.println("Resposta: " + response.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

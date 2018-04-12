package net.restapp.retrofit;

import net.restapp.model.Contract;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ContractRetrofitInterface {
    @GET("{stringContractId}/documents")
    Call<Contract> FacingContractGet(@Path("stringContractId") String stringContractId);
}

package gosmo.uble.anda.client


import dev.eder.daggerkotlinretrofit.client.EndPoints
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServiceClient {

    @POST(EndPoints.pokemonById)
    fun getPokemon(@Path("id") idPokemon: String): Observable<ResponseBody>

}

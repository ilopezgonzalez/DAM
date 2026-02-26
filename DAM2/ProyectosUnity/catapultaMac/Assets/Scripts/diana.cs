using UnityEngine;

public class diana : MonoBehaviour
{
    public float velocidad = 3f;
    public float alturaMin = -4f;
    public float alturaMax = 4f;

    private int direccion = 1; // 1 = arriba, -1 = abajo

    public GameObject explosion;
    public GameObject nuevaDiana;
    public GameObject catapulta;

    void Update()
    {
        // Movimiento vertical
        transform.Translate(Vector2.up * direccion * velocidad * Time.deltaTime);

        // Cambiar dirección al llegar arriba o abajo
        if (transform.position.y >= alturaMax) direccion = -1;
        if (transform.position.y <= alturaMin) direccion = 1;
    }

    void OnCollisionEnter2D(Collision2D collision)
    {
        // 🔹 Verificar que sea una bala
        if (collision.gameObject.CompareTag("Bala"))
        {
            // 🔥 SUMAR 3 BALAS
            if (catapulta != null)
            {
                ShooterController shooter = catapulta.GetComponent<ShooterController>();
                if (shooter != null)
                {
                    shooter.AgregarBalas(3);
                }
            }

            // Instanciar explosión
            if (explosion != null)
                Instantiate(explosion, transform.position, transform.rotation);

            // Instanciar nueva diana con pequeño offset en Y
            if (nuevaDiana != null)
            {
                Vector3 spawnPos = new Vector3(Random.Range(-8f, 8f), transform.position.y, 0f);
                Instantiate(nuevaDiana, spawnPos, transform.rotation);
            }

            // Destruir la bala
            Destroy(collision.gameObject);

            // Finalmente destruir esta diana
            Destroy(gameObject);
        }
    }
}
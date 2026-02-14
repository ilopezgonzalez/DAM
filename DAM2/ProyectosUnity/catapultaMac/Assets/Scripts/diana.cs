using UnityEngine;

public class diana : MonoBehaviour
{
    public float velocidad = 3f;
    public float alturaMin = -4f;
    public float alturaMax = 4f;

    private int direccion = 1; // 1 = arriba, -1 = abajo

    public GameObject explosion;
    public GameObject nuevaDiana;

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
    // Instanciar explosión
    if (explosion != null)
        Instantiate(explosion, transform.position, transform.rotation);

    // Instanciar nueva diana con pequeño offset en Y
    if (nuevaDiana != null)
    {
        Vector3 spawnPos = new Vector3(Random.Range(-8f, 8f), transform.position.y, 0f);
Instantiate(nuevaDiana, spawnPos, transform.rotation);

    }

    // Finalmente destruir esta diana
    Destroy(gameObject);
}
}

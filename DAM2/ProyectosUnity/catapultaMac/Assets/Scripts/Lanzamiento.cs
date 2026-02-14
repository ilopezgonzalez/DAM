using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.UIElements;

public class ShooterController : MonoBehaviour
{
    // --- Ángulo ---
    private float angulo = 0f;
    private float pasoAngulo = 15f;
    private float anguloMin = 0f;
    private float anguloMax = 90f;

    // --- Fuerza ---
    private float fuerza = 5f; //valor de la fuerza inicial
    private float pasoFuerza = 3f;
    private float fuerzaMin = 5f;
    private float fuerzaMax = 17f;

    // --- Proyectil ---
    public GameObject proyectilPrefab;

    // --- UI Toolkit ---
    public UIDocument uiDocument;   // 🔹 ARRASTRAR AQUÍ el UIDocument
    private Label labelAngulo;
    private Label labelFuerza;

    void Start()
    {
        // Obtener referencias a los Labels del UI Toolkit
        if (uiDocument != null)
        {
            var root = uiDocument.rootVisualElement;

            labelAngulo = root.Q<Label>("angulo");
            labelFuerza = root.Q<Label>("fuerza");

            // Inicializar texto
            if (labelAngulo != null)
                labelAngulo.text = "Ángulo: " + angulo;

            if (labelFuerza != null)
                labelFuerza.text = "Fuerza: " + fuerza;
        }
        else
        {
            Debug.LogWarning("No se ha asignado el UIDocument en el Inspector");
        }
    }

    void Update()
    {
        // --- CONTROL DE ANGULO ---
        if (Keyboard.current.upArrowKey.wasPressedThisFrame)
        {
            angulo += pasoAngulo;
            if (angulo > anguloMax) angulo = anguloMax;

            if (labelAngulo != null)
                labelAngulo.text = "Ángulo: " + angulo;
        }

        if (Keyboard.current.downArrowKey.wasPressedThisFrame)
        {
            angulo -= pasoAngulo;
            if (angulo < anguloMin) angulo = anguloMin;

            if (labelAngulo != null)
                labelAngulo.text = "Ángulo: " + angulo;
        }

        // --- CONTROL DE FUERZA ---
        if (Keyboard.current.rightArrowKey.wasPressedThisFrame)
        {
            fuerza += pasoFuerza;
            if (fuerza > fuerzaMax) fuerza = fuerzaMax;

            if (labelFuerza != null)
                labelFuerza.text = "Fuerza: " + fuerza;
        }

        if (Keyboard.current.leftArrowKey.wasPressedThisFrame)
        {
            fuerza -= pasoFuerza;
            if (fuerza < fuerzaMin) fuerza = fuerzaMin;

            if (labelFuerza != null)
                labelFuerza.text = "Fuerza: " + fuerza;
        }

        // --- ROTACIÓN SEGÚN ÁNGULO ---
        float rad = angulo * Mathf.Deg2Rad;
        Vector2 direccion = new Vector2(Mathf.Cos(rad), Mathf.Sin(rad));
        transform.up = direccion;

        Debug.DrawRay(transform.position, transform.up * 2f, Color.red);

        // --- DISPARAR ---
        if (Keyboard.current.spaceKey.wasPressedThisFrame)
        {
            Disparar();
        }
    }

    void Disparar()
    {
        if (proyectilPrefab == null)
        {
            Debug.LogWarning("No se ha asignado el prefab del proyectil!");
            return;
        }

        GameObject proyectil = Instantiate(proyectilPrefab, transform.position, Quaternion.identity);

        Rigidbody2D rb = proyectil.GetComponent<Rigidbody2D>();
        if (rb != null)
        {
            rb.linearVelocity = transform.up * fuerza;
        }
        else
        {
            Debug.LogWarning("El proyectil no tiene Rigidbody2D!");
        }

        Destroy(proyectil, 3f);
    }
}
